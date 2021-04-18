package com.example.cabbooking.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.cabbooking.model.Cab;
import com.example.cabbooking.model.Location;

public class CabStorage {
    private static CabStorage instance;
    private Map<String, Cab> cabs;

    private CabStorage() {
        this.cabs = new HashMap<>();
        this.cabs.put("TN57AF7676",new Cab("TN57AF7676",new Location(4,5),"Small"));
        this.cabs.put("TN57AF7677",new Cab("TN57AF7677",new Location(5,6),"Large"));
        this.cabs.put("TN57AF7678",new Cab("TN57AF7678",new Location(6,7),"Medium"));
        this.cabs.put("TN57AF7679",new Cab("TN57AF7679",new Location(7,8),"Small"));
        this.cabs.put("TN57AF7680",new Cab("TN57AF7680",new Location(8,9),"Medium"));
    }

    public static synchronized CabStorage getInstance() {
        if(instance == null) {
            instance = new CabStorage();
        }
        return instance;
    }

    public List<Cab> getCabDetails() {
        return new ArrayList<Cab>(cabs.values());
    }

}
