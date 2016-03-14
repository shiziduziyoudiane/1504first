package com.matio.seashell.bean.category;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/3/8.
 */
public class CategoryList implements Serializable {

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


        private List<CategoriesEntity> categories;

        public void setCategories(List<CategoriesEntity> categories) {
            this.categories = categories;
        }

        public List<CategoriesEntity> getCategories() {
            return categories;
        }

        public static class CategoriesEntity {
            private Object banner;

            private String icon;

            private int id;

            private String name;

            private List<SubEntity> sub;

            public void setBanner(Object banner) {
                this.banner = banner;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setSub(List<SubEntity> sub) {
                this.sub = sub;
            }

            public Object getBanner() {
                return banner;
            }

            public String getIcon() {
                return icon;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public List<SubEntity> getSub() {
                return sub;
            }

            public static class SubEntity {

                private Object banner;

                private String icon;

                private int id;

                private String name;

                public void setBanner(Object banner) {
                    this.banner = banner;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getBanner() {
                    return banner;
                }

                public String getIcon() {
                    return icon;
                }

                public int getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }
            }
        }
    }
}
