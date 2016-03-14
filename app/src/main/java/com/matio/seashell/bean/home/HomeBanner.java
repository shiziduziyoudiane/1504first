package com.matio.seashell.bean.home;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/3/8.
 */
public class HomeBanner implements Serializable {

    private int code;

    private DataEntity data;

    private boolean success;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class DataEntity {

        private List<Banners> banners;

        public void setBanners(List<Banners> banners) {
            this.banners = banners;
        }

        public List<Banners> getBanners() {
            return banners;
        }

        public static class Banners {

            private String action;

            private String image;

            private Param params;

            private String title;

            private String uri;

            public void setAction(String action) {
                this.action = action;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public void setParams(Param params) {
                this.params = params;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getAction() {
                return action;
            }

            public String getImage() {
                return image;
            }

            public Param getParams() {
                return params;
            }

            public String getTitle() {
                return title;
            }

            public String getUri() {
                return uri;
            }


            public static class Param{

                private int topic_id;

                public int getTopic_id() {
                    return topic_id;
                }

                public void setTopic_id(int topic_id) {
                    this.topic_id = topic_id;
                }
            }
        }
    }
}
