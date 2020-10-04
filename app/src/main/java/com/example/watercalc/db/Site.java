package com.example.watercalc.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Site {

    @PrimaryKey(autoGenerate = true)
    private Long id; //primary key

    private String nameOfArea;

    private String inputInfo;

    private String equipment;

    private String outputInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfArea() {
        return nameOfArea;
    }

    public void setNameOfArea(String nameOfArea) {
        this.nameOfArea = nameOfArea;
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

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", nameOfArea='" + nameOfArea + '\'' +
                ", inputInfo='" + inputInfo + '\'' +
                ", equipment='" + equipment + '\'' +
                ", outputInfo='" + outputInfo + '\'' +
                '}';
    }
}

