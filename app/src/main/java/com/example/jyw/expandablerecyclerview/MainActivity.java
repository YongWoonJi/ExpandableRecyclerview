package com.example.jyw.expandablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jyw.expandablerecyclerview.model.Child;
import com.example.jyw.expandablerecyclerview.model.GrandParent;
import com.example.jyw.expandablerecyclerview.model.Header;
import com.example.jyw.expandablerecyclerview.model.Node;
import com.example.jyw.expandablerecyclerview.model.Parent;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    RecyclerView recyclerView;

    @Bean
    TreeAdapter mAdapter;


    @AfterViews
    void init() {
        List<Node> list = setDummyList();

        mAdapter.setData(list);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }



    private List<Node> setDummyList() {
        List<Node> list = new ArrayList<>();
        Header h = new Header();
        h.setHint("부서명 혹은 이름을 입력하세요");
        list.add(h);
        GrandParent gp = new GrandParent("한미 IT");
        gp.children = new ArrayList<>();
        gp.children.add(new Parent("경영지원팀"));
        gp.children.get(0).children = new ArrayList<>();
        gp.children.get(0).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp.children.get(0).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp.children.get(0).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp.children.get(0).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp.children.get(0).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp.children.get(0).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));
        gp.children.get(0).children.add(new Child(R.drawable.image_man, "김과장", "과장", "한미IT - 경영지원팀"));
        gp.children.get(0).children.add(new Child(R.drawable.image_man3, "박차장", "차장", "한미IT - 경영지원팀"));
        gp.children.add(new Parent("서비스 운영팀"));
        gp.children.get(1).children = new ArrayList<>();
        gp.children.get(1).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp.children.get(1).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp.children.get(1).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp.children.get(1).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp.children.get(1).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));
        gp.children.get(1).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp.children.add(new Parent("프로세스 운영팀"));
        gp.children.get(2).children = new ArrayList<>();
        gp.children.get(2).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp.children.get(2).children.add(new Child(R.drawable.image_man3, "박차장", "차장", "한미IT - 경영지원팀"));
        gp.children.get(2).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp.children.get(2).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp.children.get(2).children.add(new Child(R.drawable.image_man, "김과장", "과장", "한미IT - 경영지원팀"));
        gp.children.get(2).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp.children.get(2).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp.children.get(2).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));

        GrandParent gp2 = new GrandParent("한미 메디케어(주)");
        gp2.children = new ArrayList<>();
        gp2.children.add(new Parent("경영지원팀"));
        gp2.children.get(0).children = new ArrayList<>();
        gp2.children.get(0).children.add(new Parent("새로추가맨"));
        gp2.children.get(0).children.get(0).children = new ArrayList<>();
        gp2.children.get(0).children.get(0).children.add(new Parent("또추가용"));
        gp2.children.get(0).children.get(0).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp2.children.get(0).children.get(0).children.get(0).children = new ArrayList<>();
        gp2.children.get(0).children.get(0).children.get(0).children.add(new Parent("또추가용2"));
        gp2.children.get(0).children.get(0).children.get(0).children.get(0).children = new ArrayList<>();
        gp2.children.get(0).children.get(0).children.get(0).children.get(0).children.add(new Parent("계속추가용~!!"));
        gp2.children.get(0).children.get(0).children.get(0).children.get(0).children.get(0).children = new ArrayList<>();
        gp2.children.get(0).children.get(0).children.get(0).children.get(0).children.get(0).children.add(new Child(R.drawable.image_woman2, "파파파파워", "대리", "한미IT - 경영지원팀"));
        gp2.children.get(0).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp2.children.get(0).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp2.children.get(0).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp2.children.get(0).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp2.children.get(0).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp2.children.get(0).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));
        gp2.children.get(0).children.add(new Child(R.drawable.image_man, "김과장", "과장", "한미IT - 경영지원팀"));
        gp2.children.get(0).children.add(new Child(R.drawable.image_man3, "박차장", "차장", "한미IT - 경영지원팀"));
        gp2.children.add(new Parent("서비스 운영팀"));
        gp2.children.get(1).children = new ArrayList<>();
        gp2.children.get(1).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp2.children.get(1).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp2.children.get(1).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp2.children.get(1).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp2.children.get(1).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));
        gp2.children.get(1).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp2.children.add(new Parent("프로세스 운영팀"));
        gp2.children.get(2).children = new ArrayList<>();
        gp2.children.get(2).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp2.children.get(2).children.add(new Child(R.drawable.image_man3, "박차장", "차장", "한미IT - 경영지원팀"));
        gp2.children.get(2).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp2.children.get(2).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp2.children.get(2).children.add(new Child(R.drawable.image_man, "김과장", "과장", "한미IT - 경영지원팀"));
        gp2.children.get(2).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp2.children.get(2).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp2.children.get(2).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));


        GrandParent gp3 = new GrandParent("한미약품(주)");
        gp3.children = new ArrayList<>();
        gp3.children.add(new Parent("경영지원팀"));
        gp3.children.get(0).children = new ArrayList<>();
        gp3.children.get(0).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp3.children.get(0).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp3.children.get(0).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp3.children.get(0).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp3.children.get(0).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp3.children.get(0).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));
        gp3.children.get(0).children.add(new Child(R.drawable.image_man, "김과장", "과장", "한미IT - 경영지원팀"));
        gp3.children.get(0).children.add(new Child(R.drawable.image_man3, "박차장", "차장", "한미IT - 경영지원팀"));
        gp3.children.add(new Parent("서비스 운영팀"));
        gp3.children.get(1).children = new ArrayList<>();
        gp3.children.get(1).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp3.children.get(1).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp3.children.get(1).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp3.children.get(1).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp3.children.get(1).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));
        gp3.children.get(1).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp3.children.add(new Parent("프로세스 운영팀"));
        gp3.children.get(2).children = new ArrayList<>();
        gp3.children.get(2).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp3.children.get(2).children.add(new Child(R.drawable.image_man3, "박차장", "차장", "한미IT - 경영지원팀"));
        gp3.children.get(2).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp3.children.get(2).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp3.children.get(2).children.add(new Child(R.drawable.image_man, "김과장", "과장", "한미IT - 경영지원팀"));
        gp3.children.get(2).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp3.children.get(2).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp3.children.get(2).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));


        GrandParent gp4 = new GrandParent("한미 정밀화학(주)");
        gp4.children = new ArrayList<>();
        gp4.children.add(new Parent("경영지원팀"));
        gp4.children.get(0).children = new ArrayList<>();
        gp4.children.get(0).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp4.children.get(0).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp4.children.get(0).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp4.children.get(0).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp4.children.get(0).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp4.children.get(0).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));
        gp4.children.get(0).children.add(new Child(R.drawable.image_man, "김과장", "과장", "한미IT - 경영지원팀"));
        gp4.children.get(0).children.add(new Child(R.drawable.image_man3, "박차장", "차장", "한미IT - 경영지원팀"));
        gp4.children.add(new Parent("서비스 운영팀"));
        gp4.children.get(1).children = new ArrayList<>();
        gp4.children.get(1).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp4.children.get(1).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp4.children.get(1).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp4.children.get(1).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp4.children.get(1).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));
        gp4.children.get(1).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp4.children.add(new Parent("프로세스 운영팀"));
        gp4.children.get(2).children = new ArrayList<>();
        gp4.children.get(2).children.add(new Child(R.drawable.image_man2, "정우성", "인턴", "한미IT - 경영지원팀"));
        gp4.children.get(2).children.add(new Child(R.drawable.image_man3, "박차장", "차장", "한미IT - 경영지원팀"));
        gp4.children.get(2).children.add(new Child(R.drawable.image_woman2, "아이린", "대리", "한미IT - 경영지원팀"));
        gp4.children.get(2).children.add(new Child(R.drawable.image_man, "노민석", "차장", "한미IT - 경영지원팀"));
        gp4.children.get(2).children.add(new Child(R.drawable.image_man, "김과장", "과장", "한미IT - 경영지원팀"));
        gp4.children.get(2).children.add(new Child(R.drawable.image_man3, "문진우", "사원", "한미IT - 경영지원팀"));
        gp4.children.get(2).children.add(new Child(R.drawable.image_woman, "방효진", "대리", "한미IT - 경영지원팀"));
        gp4.children.get(2).children.add(new Child(R.drawable.image_woman, "서현", "대리", "한미IT - 경영지원팀"));


        list.add(gp);
        list.add(gp2);
        list.add(gp3);
        list.add(gp4);
        return list;
    }

}
