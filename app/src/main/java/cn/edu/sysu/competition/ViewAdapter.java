package cn.edu.sysu.competition;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Emilia on 2017/11/26.
 * This is the adapter of welcome view pager
 */

public class ViewAdapter extends PagerAdapter {

    private List<View> mList;

    public ViewAdapter(List<View> viewList) {mList = viewList;}

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mList.get(position));
        return mList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position));
    }

}
