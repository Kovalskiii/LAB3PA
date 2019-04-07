package com.example.lab3_pa.MVP;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import com.example.lab3_pa.AUTO.Automobil;
import com.example.lab3_pa.AUTO.Moto;
import com.example.lab3_pa.AUTO.Truck;
import com.example.lab3_pa.AUTO.Vehicle;



public class MainRepository implements MainContract.MainRepository
{
    private List<Vehicle> vehicles;
    public MainRepository()
    {
        vehicles = generateList();
    }

    static private List<Vehicle> generateList()
    {
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < 40; i++)
        {
            if (i % 3 == 0)
                vehicles.add(new Truck());
            else if (i % 3 == 1)
                vehicles.add(new Moto());
            else if (i % 3 == 2)
                vehicles.add(new Automobil());
        }

        return vehicles;
    }

    @Override
    public void sort(MainContract.SortBy sortBy, boolean reversed) {
        Comparator<Vehicle> vehicleComparator = null;
        int multiplier = reversed ? -1 : 1;
        switch(sortBy)
        {
            case FUEL_TANK:
                vehicleComparator = ((o1, o2) -> multiplier * Integer.compare(o1.getFuelTank(), o2.getFuelTank()));
                break;
            case ENGINE_CAPACITY:
                vehicleComparator = ((o1, o2) -> multiplier * Float.compare(o1.getEngineCapacity(), o2.getEngineCapacity()));
                break;
            case FUEL_LEVEL:
                vehicleComparator = ((o1, o2) -> multiplier * Integer.compare(o1.getFuelLevel(), o2.getFuelLevel()));
                break;
            case WHEEL_NUMBER:
                vehicleComparator = ((o1, o2) -> multiplier * Integer.compare(o1.getWheelNumber(), o2.getWheelNumber()));
                break;
        }

        vehicles.sort(vehicleComparator);
    }

    public void remove(int id)
    {
        vehicles.remove(id);
    }

    @Override
    public void reload() {
        vehicles.clear();
        vehicles.addAll(generateList());
    }


    @Override
    public List<Vehicle> getVehicles()
    {
        return vehicles;
    }
}
