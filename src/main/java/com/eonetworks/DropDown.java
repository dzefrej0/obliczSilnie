package com.eonetworks;

/**
 * Created by dzefrej0 on 15.03.2017.
 */
public enum DropDown {



    PLASTIC("PLASTIC"),
    WOOD("WOOD");


    public static final DropDown[] ALL = { PLASTIC, WOOD };


    private final String name;


    public static DropDown forName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null for type");
        }
        if (name.toUpperCase().equals("PLASTIC")) {
            return PLASTIC;
        } else if (name.toUpperCase().equals("WOOD")) {
            return WOOD;
        }
        throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any Type");
    }


    private DropDown(final String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }


}