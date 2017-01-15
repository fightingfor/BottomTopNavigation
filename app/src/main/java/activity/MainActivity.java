package activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import fragment.FristFragment;
import navigation.ljg.com.bottomtopnavigation.R;

public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabhost;
    private Class<?> fragmentArray[]={FristFragment.class,FristFragment.class,FristFragment.class,FristFragment.class};
    private int imageArray[]={R.drawable.tab_icon_new,R.drawable.tab_icon_tweet,R.drawable.tab_icon_explore,R.drawable.tab_icon_me};
    private String titleArray[]={"新闻","动态","发现","我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }

    /**
     * 初始化tab
     */
    private void initTab() {
        mTabhost= (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabhost.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        for (int i=0;i<fragmentArray.length;i++){
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec("tag" + i).setIndicator(getTabItemView(i));
            mTabhost.addTab(tabSpec,fragmentArray[i],null);
        }
    }

    private View getTabItemView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab, null);
        ImageView image_tab = (ImageView) view.findViewById(R.id.image_tab);
        image_tab.setImageResource(imageArray[i]);
        TextView tv_tab = (TextView) view.findViewById(R.id.tv_tab);
        tv_tab.setText(titleArray[i]);
        return view;
    }
}
