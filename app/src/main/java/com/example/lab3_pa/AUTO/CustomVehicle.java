package com.example.lab3_pa.AUTO;

import com.example.lab3_pa.R;

public class CustomVehicle extends VehicleType {

    public CustomVehicle(int fuel_tank, int fuel_level, int wheel_number, int photo_res_id, float engine_capacity) {
        this.fuel_tank = fuel_tank;
        this.fuel_level = fuel_level;
        this.wheel_number = wheel_number;
        this.photo_res_id = photo_res_id;
        this.engine_capacity = engine_capacity;
    }

    private int fuel_tank, fuel_level, wheel_number, photo_res_id;
    private float engine_capacity;
    
    @Override
    public String getEngineType()
    {
        return "petrol";
    }

    @Override
    public int getFuelTank()
    {
        return fuel_tank;
    }

    @Override
    public int getFuelLevel()
    {
        return fuel_level;
    }

    @Override
    public float getEngineCapacity()
    {
        return engine_capacity;
    }

    @Override
    public int getWheelNumber()
    {
        return wheel_number;
    }

    @Override
    public int getPhotoResId() {
        return photo_res_id;
    }
}
