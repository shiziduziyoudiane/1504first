package com.matio.seashell.bean.home;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/3/8.
 */
public class HomeDetail implements Serializable {

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

        private ProductEntity product;

        public void setProduct(ProductEntity product) {
            this.product = product;
        }

        public ProductEntity getProduct() {
            return product;
        }

        public static class ProductEntity {

            private int category_id;

            private CurrentSkuEntity current_sku;

            private List<?> custom_properties;

            private String desc;

            private String fav_count;

            public String getFav_count() {
                return fav_count;
            }

            public void setFav_count(String fav_count) {
                this.fav_count = fav_count;
            }

            private boolean favorite;

            private int id;

            private List<ImagesEntity> images;

            private String location;

            private MerchantEntity merchant;

            private String name;

            private int review_count;

            private String score;

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            private List<SkusEntity> skus;

            private SpecsEntity specs;

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public void setCurrent_sku(CurrentSkuEntity current_sku) {
                this.current_sku = current_sku;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setFavorite(boolean favorite) {
                this.favorite = favorite;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public void setMerchant(MerchantEntity merchant) {
                this.merchant = merchant;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setReview_count(int review_count) {
                this.review_count = review_count;
            }

            public void setSpecs(SpecsEntity specs) {
                this.specs = specs;
            }

            public void setCustom_properties(List<?> custom_properties) {
                this.custom_properties = custom_properties;
            }

            public void setImages(List<ImagesEntity> images) {
                this.images = images;
            }

            public void setSkus(List<SkusEntity> skus) {
                this.skus = skus;
            }

            public int getCategory_id() {
                return category_id;
            }

            public CurrentSkuEntity getCurrent_sku() {
                return current_sku;
            }

            public String getDesc() {
                return desc;
            }

            public boolean isFavorite() {
                return favorite;
            }

            public int getId() {
                return id;
            }

            public String getLocation() {
                return location;
            }

            public MerchantEntity getMerchant() {
                return merchant;
            }

            public String getName() {
                return name;
            }

            public int getReview_count() {
                return review_count;
            }


            public SpecsEntity getSpecs() {
                return specs;
            }

            public List<?> getCustom_properties() {
                return custom_properties;
            }

            public List<ImagesEntity> getImages() {
                return images;
            }

            public List<SkusEntity> getSkus() {
                return skus;
            }

            public static class CurrentSkuEntity {

                private int discount;

                private int id;

                private ListPriceEntity list_price;

                private RealPriceEntity real_price;

                private Object spec;

                private int stock;

                public void setDiscount(int discount) {
                    this.discount = discount;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setList_price(ListPriceEntity list_price) {
                    this.list_price = list_price;
                }

                public void setReal_price(RealPriceEntity real_price) {
                    this.real_price = real_price;
                }

                public void setSpec(Object spec) {
                    this.spec = spec;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public int getDiscount() {
                    return discount;
                }

                public int getId() {
                    return id;
                }

                public ListPriceEntity getList_price() {
                    return list_price;
                }

                public RealPriceEntity getReal_price() {
                    return real_price;
                }

                public Object getSpec() {
                    return spec;
                }

                public int getStock() {
                    return stock;
                }

                public static class ListPriceEntity {
                    private int CNY;

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }

                    public int getCNY() {
                        return CNY;
                    }
                }

                public static class RealPriceEntity {
                    private int CNY;

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }

                    public int getCNY() {
                        return CNY;
                    }
                }
            }

            public static class MerchantEntity {

                private int id;

                private String name;

                private String score;

                public String getScore() {
                    return score;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }


            }

            public static class SpecsEntity {
            }

            public static class ImagesEntity {
                private int h;

                private int t_h;

                private int t_w;

                private String thumb;

                private String url;

                private int w;

                public void setH(int h) {
                    this.h = h;
                }

                public void setT_h(int t_h) {
                    this.t_h = t_h;
                }

                public void setT_w(int t_w) {
                    this.t_w = t_w;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public void setW(int w) {
                    this.w = w;
                }

                public int getH() {
                    return h;
                }

                public int getT_h() {
                    return t_h;
                }

                public int getT_w() {
                    return t_w;
                }

                public String getThumb() {
                    return thumb;
                }

                public String getUrl() {
                    return url;
                }

                public int getW() {
                    return w;
                }
            }

            public static class SkusEntity {
                private int discount;

                private int id;

                private ListPriceEntity list_price;

                private RealPriceEntity real_price;

                private Object spec;

                private int stock;

                public void setDiscount(int discount) {
                    this.discount = discount;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setList_price(ListPriceEntity list_price) {
                    this.list_price = list_price;
                }

                public void setReal_price(RealPriceEntity real_price) {
                    this.real_price = real_price;
                }

                public void setSpec(Object spec) {
                    this.spec = spec;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public int getDiscount() {
                    return discount;
                }

                public int getId() {
                    return id;
                }

                public ListPriceEntity getList_price() {
                    return list_price;
                }

                public RealPriceEntity getReal_price() {
                    return real_price;
                }

                public Object getSpec() {
                    return spec;
                }

                public int getStock() {
                    return stock;
                }

                public static class ListPriceEntity {

                    private int CNY;

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }

                    public int getCNY() {
                        return CNY;
                    }
                }

                public static class RealPriceEntity {
                    private int CNY;

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }

                    public int getCNY() {
                        return CNY;
                    }
                }
            }
        }
    }
}
