package com.matio.seashell.bean.discover;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/3/8.
 */
public class DiscoverList implements Serializable {

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

        private List<TopicsEntity> topics;

        public void setTopics(List<TopicsEntity> topics) {
            this.topics = topics;
        }

        public List<TopicsEntity> getTopics() {
            return topics;
        }

        public static class TopicsEntity {

            private int id;

            private String image;

            private String title;

            public void setId(int id) {
                this.id = id;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getId() {
                return id;
            }

            public String getImage() {
                return image;
            }

            public String getTitle() {
                return title;
            }
        }
    }
}
