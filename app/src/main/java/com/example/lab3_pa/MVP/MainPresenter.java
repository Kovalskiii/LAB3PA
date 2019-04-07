package com.example.lab3_pa.MVP;


import com.example.lab3_pa.AUTO.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainPresenter implements MainContract.MainPresenter
{
    private MainContract.MainView mView;
    private MainContract.MainRepository mRepository;
    private Map<MainContract.SortBy, Boolean> mSortStatus = new HashMap<MainContract.SortBy, Boolean>();

    public MainPresenter(MainContract.MainView view)
    {
        this.mView = view;
        this.mRepository = new MainRepository();
    }

    @Override
    public List<Vehicle> getList() {
        return mRepository.getVehicles();
    }

    @Override
    public void OnSortClicked(MainContract.SortBy sortBy)
    {
        Boolean clicked = mSortStatus.get(sortBy);
        boolean reversed = false;
        if (clicked == null || clicked == false)
        {
            mSortStatus.put(sortBy, true);
            reversed = false;

        } else {
            mSortStatus.put(sortBy, false);
            reversed = true;

        }
        mRepository.sort(sortBy, reversed);
        mView.toast(String.format("Sorted by %s %s", sortBy, reversed?"reversed":""));
    }

    @Override
    public void OnRemove(int id) {
        this.mRepository.remove(id);
    }

    @Override
    public void OnReload() {
        mRepository.reload();
        mView.toast("Reloaded...");
    }
}


