package com.pas.domain;

/**
 * Created by lucas on 22/05/2017.
 */
public abstract class ClassificationEntity extends Entity {
    private String classification;
    private double accuracy;

    public ClassificationEntity() {}

    public ClassificationEntity(String classification, double accuracy) {
        this.classification = classification;
        this.accuracy = accuracy;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
