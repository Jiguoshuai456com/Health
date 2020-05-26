package com.wd.login.bean;

import java.util.List;

/*
 *@Auther:cln
 *@Date: 2020/5/26
 *@Time:22:32
 *@Description:
 * */public class login_SinckCircleBean {

    /**
     * result : [{"amount":10,"detail":"挺好的医生","releaseTime":1569168000000,"sickCircleId":34,"title":"宝贝"},{"amount":10,"detail":"不是表面的背痛，是内里的腰部疼痛，本人一直从事长时间坐姿的工作，导致腰部经常酸痛，而且工比较忙，一直没有时间去看，导致最近有点疼的厉害。求一个治疗方案。","releaseTime":1569168000000,"sickCircleId":33,"title":"腰有点疼，求个好的治疗方案"},{"amount":20,"detail":"本来这几天脖子就有点疼，本打算今天去医院看一下的，结果还下这么大的雨，只能等等再去看了，想先求一个可行的方案。","releaseTime":1569168000000,"sickCircleId":32,"title":"今天早上起来脖子动不了了"},{"amount":10,"detail":"由于长时间从事重体力劳动，导致膝盖受力有点严重，一直都有一些小毛病，最近天气有点冷，病症有点严重，问一下有什么好的治疗方法没有？","releaseTime":1569168000000,"sickCircleId":31,"title":"膝关节损伤"},{"amount":20,"detail":"今天早上跟朋友打球的时候碰到一起了，落地的时候就把脚给扭了，肿得有点高，走路有点困难，有什么比较好的解决方案吗？","releaseTime":1569168000000,"sickCircleId":30,"title":"今天打球把脚崴了，有紧急治疗方法吗？"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * amount : 10
         * detail : 挺好的医生
         * releaseTime : 1569168000000
         * sickCircleId : 34
         * title : 宝贝
         */

        private int amount;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
