package com.example.lab3_pa.MVP;

import com.example.lab3_pa.AUTO.Vehicle;

import java.util.List;

public interface MainContract
{
    enum SortBy {FUEL_TANK, FUEL_LEVEL, ENGINE_CAPACITY, WHEEL_NUMBER}
     interface MainRepository
    {

        void sort(SortBy sortBy, boolean reversed);
        void remove(int id);
        void reload();
        List<Vehicle> getVehicles();
    }

    interface MainPresenter
    {
        List<Vehicle> getList();
        void OnSortClicked(SortBy sortBy);
       void OnRemove(int id);
        void OnReload();
    }

    interface MainView
    {
        void showVehicles(List<Vehicle> vehicles);
        void toast(String message);
    }
}
