package com.wd.first.bean;

import java.io.Serializable;

public class DetailsBean implements Serializable {
    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean implements Serializable{
        private String benefitTaboo;
        private long createTime;
        private int diseaseCategoryId;
        private int id;
        private String pathology;
        private String symptom;
        private String westernMedicineTreatment;

        public String getBenefitTaboo() {
            return benefitTaboo;
        }

        public void setBenefitTaboo(String benefitTaboo) {
            this.benefitTaboo = benefitTaboo;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getDiseaseCategoryId() {
            return diseaseCategoryId;
        }

        public void setDiseaseCategoryId(int diseaseCategoryId) {
            this.diseaseCategoryId = diseaseCategoryId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPathology() {
            return pathology;
        }

        public void setPathology(String pathology) {
            this.pathology = pathology;
        }

        public String getSymptom() {
            return symptom;
        }

        public void setSymptom(String symptom) {
            this.symptom = symptom;
        }

        public String getWesternMedicineTreatment() {
            return westernMedicineTreatment;
        }

        public void setWesternMedicineTreatment(String westernMedicineTreatment) {
            this.westernMedicineTreatment = westernMedicineTreatment;
        }
    }
}
