package com.example.jyw.expandablerecyclerview;

import android.view.View;
import android.view.ViewGroup;

import com.example.jyw.expandablerecyclerview.model.Child;
import com.example.jyw.expandablerecyclerview.model.GrandParent;
import com.example.jyw.expandablerecyclerview.model.Header;
import com.example.jyw.expandablerecyclerview.model.Node;
import com.example.jyw.expandablerecyclerview.model.Parent;

import org.androidannotations.annotations.EBean;

import java.util.List;

/**
 * Created by JYW on 2017-03-19 019.
 */
@EBean
public class TreeAdapter extends BaseAdapter {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_GRAND_PARENT = 1;
    private static final int TYPE_PARENT = 2;
    private static final int TYPE_CHILD = 3;

    List<Node> list;

    int nodeSize;

    public void setData(List<Node> list) {
        this.list = list;
        for (Node n : list) {
            setListParent(n);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }

        Node node = list.get(position);
        if (node instanceof GrandParent) {
            return TYPE_GRAND_PARENT;
        } else if (node instanceof Parent) {
            return TYPE_PARENT;
        } else if (node instanceof Child) {
            return TYPE_CHILD;
        }

        throw new IllegalArgumentException("invalid view type");
    }


    @Override
    protected View onCreateItemView(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return HeaderView_.build(parent.getContext());
            case TYPE_GRAND_PARENT:
                return GrandParentView_.build(parent.getContext());
            case TYPE_PARENT:
                return ParentView_.build(parent.getContext());
            case TYPE_CHILD:
                return ChildView_.build(parent.getContext());
        }
        throw new IllegalArgumentException("invalid view type");
    }


    @Override
    public void onBindViewHolder(ViewWrapper holder, int position) {
        if (position == 0) {
            HeaderView view = (HeaderView) holder.getView();
            Header data = (Header) list.get(position);
            view.bind(data.getHint());
            return;
        }

        Node node = list.get(position);

        switch (holder.getItemViewType()) {
            case TYPE_GRAND_PARENT: {
                final GrandParent item = (GrandParent) node;
                final GrandParentView view = (GrandParentView) holder.getView();
                view.bind(item);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.isExpand()) {
                            setNodeCollapse(item);
                            view.imageFold.setImageResource(R.drawable.btn_unfold_selector);
                        } else {
                            setNodeExpand(item);
                            view.imageFold.setImageResource(R.drawable.btn_fold_selector);
                        }
                    }
                });

                break;
            }

            case TYPE_PARENT: {
                final Parent item = (Parent) node;
                final ParentView view = (ParentView) holder.getView();
                view.bind(item);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.isExpand()) {
                            setNodeCollapse(item);
                            view.imageFold.setImageResource(R.drawable.btn_unfold_selector);
                        } else {
                            setNodeExpand(item);
                            view.imageFold.setImageResource(R.drawable.btn_fold_selector);
                        }
                    }
                });

                break;
            }

            case TYPE_CHILD: {
                Child cItem = (Child) node;
                ChildView cView = (ChildView) holder.getView();
                cView.bind(cItem);
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    private void getNodeSize(Node node) {
        if (node.children != null) {
            nodeSize += node.children.size();

            for (int i = 0; i < node.children.size(); i++) {
                if (node.children.get(i).isExpand()) {
                    getNodeSize(node.children.get(i));
                }
            }
        }
    }


    private void setExpand(Node node, boolean expand) {
        if (node.children != null) {
            for (int i = 0; i < node.children.size(); i++) {
                node.children.get(i).setExpand(expand);
                setExpand(node.children.get(i), false);
            }
        }
    }


    private void setListParent(Node node) {
        if (node.children != null) {
            for (int i = 0; i < node.children.size(); i++) {
                node.children.get(i).setParent(node);
                setListParent(node.children.get(i));
            }
        }
    }


    private void setNodeExpand(Node node) {
        if (node.children != null) {
            int position = list.indexOf(node);
            int index = position + 1;

            for (Node p : node.children) {
                p.setExpand(false);
                list.add(index, p);
                index++;
            }

            notifyItemRangeInserted(position + 1, index - position - 1);
            node.setExpand(true);
        }
    }


    private void setNodeCollapse(Node node) {
        if (node.children != null) {
            nodeSize = 0;
            getNodeSize(node);
            setExpand(node, false);
            int position = list.indexOf(node);
            int removeCount = 0;

            while (removeCount < nodeSize) {
                list.remove(position + 1);
                removeCount++;
            }

            notifyItemRangeRemoved(position + 1, nodeSize);
            node.setExpand(false);
        }
    }

}
