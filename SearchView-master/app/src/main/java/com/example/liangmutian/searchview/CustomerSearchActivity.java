package com.example.liangmutian.searchview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liangmutian.searchview.swipetoloadlayout.BaseRecyclerAdapter;
import com.example.liangmutian.searchview.swipetoloadlayout.OnLoadMoreListener;
import com.example.liangmutian.searchview.swipetoloadlayout.OnRefreshListener;
import com.example.liangmutian.searchview.swipetoloadlayout.SuperRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class CustomerSearchActivity extends Activity implements OnRefreshListener, OnLoadMoreListener {
    private final static int NoThing = 0;
    private final static int Show = 1;
    private final static int Cant_find = 2;

    private SuperRefreshRecyclerView superRecyclerView;
    private CustomerCampanySearchAdapter adapter;
    private List<Customer> customerList = new ArrayList<>();
    private EditText editMobile;
    private RelativeLayout rlCantFind;
    private TextView tvKey;
    private List<Customer> dataList = new ArrayList<>();
    private List<Customer> list2 = new ArrayList<>();//after search
    int customerNum = 0;
    private List<Customer> list = new ArrayList<>();
    private boolean isSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_customer_search);
        initViews();
        initData();
    }



    public void initViews() {
        superRecyclerView = (SuperRefreshRecyclerView) findViewById(R.id.super_recyclerview);
        superRecyclerView.init(new LinearLayoutManager(this), this, this);
        superRecyclerView.setRefreshEnabled(false);
        superRecyclerView.setLoadingMoreEnable(false);
        rlCantFind = (RelativeLayout) findViewById(R.id.rl_cant_find_over);
        editMobile = (EditText) findViewById(R.id.edit_search);
        editMobile.addTextChangedListener(textWatcher);
        tvKey = (TextView) findViewById(R.id.tv_key);


    }

    public void initData() {
        list.add(new Customer("西南财经大学关于2020年春季学期学生返校的通知"));
        list.add(new Customer("西南财经大学中外合作办学项目2019年报信息公示"));
        list.add(new Customer("关于2020年劳动节放假有关安排的通知"));
        list.add(new Customer("第五届刘诗白经济学奖评奖公告"));
        list.add(new Customer("关于征集献礼西南财经大学95周年校庆摄影作品的通知"));
        list.add(new Customer("关于2020年清明节放假安排的通知"));
        list.add(new Customer("关于学习贯彻《高等学校新型冠状病毒肺炎防控指南》的通知"));
        list.add(new Customer("西南财经大学致全体女教职工的慰问信"));
        list.add(new Customer("2020年春季学期疫情防控期间两校区后勤服务信息"));
        list.add(new Customer("不忘初心、牢记使命，学以报国、立德树人——西南财经大学致全校教师的一封信"));
        list.add(new Customer("众志成城、共克时艰，只争朝夕、不负韶华——西南财经大学致全体学生的一封信"));
        list.add(new Customer("关于2020年春季学期开学相关工作安排的通知"));
        list.add(new Customer("关于2020年下半年赴任汉语教师志愿者报名的通知"));
        list.add(new Customer("关于2020年春季学期开学时间的通知"));
        list.add(new Customer("致全体西财校友的慰问信"));
        list.add(new Customer("关于进一步加强校园管控的通知"));

        showData();

        if (list != null && list.size() > 0) {
            dataList.addAll(list);
        }

        for (int i = 0; i < dataList.size(); i++) {
            dataList.get(i).name = dataList.get(i).organizationName;
        }
    }

    private void showData() {
        if (list == null || list.size() == 0)
            return;
        customerList.clear();
        customerList.addAll(list);
        adapter = new CustomerCampanySearchAdapter(customerList, this, null);
        superRecyclerView.setAdapter(adapter);
        superRecyclerView.showData();

        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(CustomerSearchActivity.this,MainActivity.class);
                switch (position){
                    case 0:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15329.htm");
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15269.htm");
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15219.htm");
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15170.htm");
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15089.htm");
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15070.htm");
                        startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14959.htm");
                        startActivity(intent);
                        break;
                    case 7:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14921.htm");
                        startActivity(intent);
                        break;
                    case 8:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14909.htm");
                        startActivity(intent);
                        break;
                    case 9:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14829.htm");
                        startActivity(intent);
                        break;
                    case 10:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14819.htm");
                        startActivity(intent);
                        break;
                    case 11:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14749.htm");
                        startActivity(intent);
                        break;
                    case 12:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14679.htm");
                        startActivity(intent);
                        break;
                    case 13:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14661.htm");
                        startActivity(intent);
                        break;
                    case 14:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14650.htm");
                        startActivity(intent);
                        break;
                    case 15:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14649.htm");
                        startActivity(intent);
                        break;

                }
            }
        });

    }

    public void showCustomer(List<Customer> list, String key) {
        if (list == null || list.size() == 0)
            return;
        customerList.clear();
        customerList.addAll(list);
        adapter = new CustomerCampanySearchAdapter(customerList, this, key);
        superRecyclerView.setAdapter(adapter);
        superRecyclerView.showData();

        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(CustomerSearchActivity.this,MainActivity.class);
                switch (position){
                    case 0:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15329.htm");
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15269.htm");
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15219.htm");
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15170.htm");
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15089.htm");
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/15070.htm");
                        startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14959.htm");
                        startActivity(intent);
                        break;
                    case 7:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14921.htm");
                        startActivity(intent);
                        break;
                    case 8:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14909.htm");
                        startActivity(intent);
                        break;
                    case 9:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14829.htm");
                        startActivity(intent);
                        break;
                    case 10:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14819.htm");
                        startActivity(intent);
                        break;
                    case 11:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14749.htm");
                        startActivity(intent);
                        break;
                    case 12:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14679.htm");
                        startActivity(intent);
                        break;
                    case 13:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14661.htm");
                        startActivity(intent);
                        break;
                    case 14:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14650.htm");
                        startActivity(intent);
                        break;
                    case 15:
                        intent.putExtra("url","https://www.swufe.edu.cn/info/1003/14649.htm");
                        startActivity(intent);
                        break;

                }
            }
        });

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }


    public void changeStates(int states) {
        switch (states) {
            case NoThing:
                rlCantFind.setVisibility(View.INVISIBLE);
                superRecyclerView.setVisibility(View.VISIBLE);
                showData();
                break;
            case Show:
                rlCantFind.setVisibility(View.INVISIBLE);
                superRecyclerView.setVisibility(View.VISIBLE);
                break;
            case Cant_find:
                rlCantFind.setVisibility(View.VISIBLE);
                superRecyclerView.setVisibility(View.GONE);
                break;


        }

    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (!TextUtils.isEmpty(charSequence)) {

                searchByTel(charSequence);
                if (customerNum == 0) {
                    changeStates(Cant_find);
                    tvKey.setText(charSequence + "");
                } else {
                    changeStates(Show);
                }
                showCustomer(list2, charSequence + "");
            } else {
                changeStates(NoThing);
            }
        }


        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private List<Customer> searchByTel(CharSequence key) {
        list2.clear();
        customerNum = 0;
        for (int i = 0; i < dataList.size(); i++) {

            if (dataList.get(i).name.contains(key)) {
                customerNum++;
                list2.add(dataList.get(i));
            }

        }

        return list2;
    }


    public static void into(Activity context) {
        Intent intent = new Intent(context, CustomerSearchActivity.class);
        context.startActivity(intent);
    }

}


