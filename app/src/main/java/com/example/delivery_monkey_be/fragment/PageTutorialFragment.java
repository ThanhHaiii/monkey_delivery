package com.example.delivery_monkey_be.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.delivery_monkey_be.R;

import java.util.ArrayList;
import java.util.List;

public class PageTutorialFragment extends BaseFragment {

    private FragmentActivity fragmentActivity;

    private ViewPager2 mViewPager;
    private RadioGroup mRadioGroup;
    private ImageView next_button;
    private final List<Fragment> mListFragment = new ArrayList<>();

    public enum PagerTutorialContents {
        ONE(R.string.title_pager_one, R.drawable.tutorial_one, R.string.mes_pager_one, 1),
        TWO(R.string.title_pager_two, R.drawable.tutorial_two, R.string.mes_pager_two, 2),
        THREE(R.string.title_pager_three, R.drawable.tutorial_three, R.string.mes_pager_three, 3);

        private final int title;
        private final int textID;
        private final int img;
        private final int position;

        PagerTutorialContents(int title, int img, int textID, int position) { // コンストラクタの定義
            this.title = title;
            this.img = img;
            this.textID = textID;
            this.position = position;
        }

        public String getTitle(Context context) {
            return context.getString(title);
        }

        public String getText(Context context) {
            return context.getString(textID);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tutorial, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initData();
        initEvent();

        setSelect(0);
    }

    private void initView(View view) {
        mViewPager = view.findViewById(R.id.vp_page);
        mRadioGroup = view.findViewById(R.id.rg_point_payment);

        for (PagerTutorialContents contents: PagerTutorialContents.values()) {
            RadioButton radioButton = new RadioButton(fragmentActivity);
            radioButton.setButtonDrawable(R.drawable.indicator_selector);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(
                    (int) fragmentActivity.getResources().getDimension(R.dimen.dp8), ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMarginStart((int) fragmentActivity.getResources().getDimension(R.dimen.dp70));
            layoutParams.setMarginEnd((int) fragmentActivity.getResources().getDimension(R.dimen.dp70));

            mRadioGroup.addView(radioButton, layoutParams);
            mListFragment.add(PagerFragment.newInstance(fragmentActivity, contents.getTitle(fragmentActivity),
                    contents.getText(fragmentActivity), contents.img, contents.position));
        }

        next_button = view.findViewById(R.id.next_btn);
    }

    private void setSelect(int select) {
        ((RadioButton) mRadioGroup.getChildAt(select)).setChecked(true);
        mViewPager.setCurrentItem(select);
    }

    private void initData() {
        mViewPager.setAdapter(new FragmentStateAdapter(fragmentActivity) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return mListFragment.get(position);
            }

            @Override
            public int getItemCount() {
                return mListFragment.size();
            }
        });
        mViewPager.setOffscreenPageLimit(3);
    }

    private void initEvent() {
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setSelect(position);
                ((PagerFragment) mListFragment.get(position)).initData();
            }
        });

        for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
            int index = i;
            mRadioGroup.getChildAt(index).setOnClickListener(v -> mViewPager.setCurrentItem(index));
        }
    }
}
