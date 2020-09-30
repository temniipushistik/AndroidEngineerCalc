package com.example.watercalc.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Site {

    @PrimaryKey
  private Long mId;//primary key

    @ColumnInfo(name = "name_of_area")
    private String mName;

    @ColumnInfo(name = "input_info")
    private String inputInfo;

    @ColumnInfo(name = "equipment")
    private String equipment;

    @ColumnInfo(name = "output_info")
    private String outputInfo;


    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getInputInfo() {
        return inputInfo;
    }

    public void setInputInfo(String inputInfo) {
        this.inputInfo = inputInfo;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getOutputInfo() {
        return outputInfo;
    }

    public void setOutputInfo(String outputInfo) {
        this.outputInfo = outputInfo;
    }
}

