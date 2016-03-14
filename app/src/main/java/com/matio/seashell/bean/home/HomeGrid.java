package com.matio.seashell.bean.home;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Angel on 2016/3/8.
 */
public class HomeGrid implements Serializable {

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

        private List<ProductsEntity> products;

        public void setProducts(List<ProductsEntity> products) {
            this.products = products;
        }

        public List<ProductsEntity> getProducts() {
            return products;
        }

        public static class ProductsEntity {

            private int category_id;

            private CurrentSkuEntity current_sku;

            private int fav_count;

            private boolean favorite;

            private int id;

            private int like_count;

            private String location;

            private MerchantEntity merchant;

            private int merchant_id;

            private String name;

            private int product_id;

            private int rank;

            private int review_count;

            private int score;

            private int sku_id;

            private String url;

            private List<ImagesEntity> images;

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public void setCurrent_sku(CurrentSkuEntity current_sku) {
                this.current_sku = current_sku;
            }

            public void setFav_count(int fav_count) {
                this.fav_count = fav_count;
            }

            public void setFavorite(boolean favorite) {
                this.favorite = favorite;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public void setMerchant(MerchantEntity merchant) {
                this.merchant = merchant;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public void setReview_count(int review_count) {
                this.review_count = review_count;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public void setSku_id(int sku_id) {
                this.sku_id = sku_id;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setImages(List<ImagesEntity> images) {
                this.images = images;
            }

            public int getCategory_id() {
                return category_id;
            }

            public CurrentSkuEntity getCurrent_sku() {
                return current_sku;
            }

            public int getFav_count() {
                return fav_count;
            }

            public boolean isFavorite() {
                return favorite;
            }

            public int getId() {
                return id;
            }

            public int getLike_count() {
                return like_count;
            }

            public String getLocation() {
                return location;
            }

            public MerchantEntity getMerchant() {
                return merchant;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public String getName() {
                return name;
            }

            public int getProduct_id() {
                return product_id;
            }

            public int getRank() {
                return rank;
            }

            public int getReview_count() {
                return review_count;
            }

            public int getScore() {
                return score;
            }

            public int getSku_id() {
                return sku_id;
            }

            public String getUrl() {
                return url;
            }

            public List<ImagesEntity> getImages() {
                return images;
            }

            public static class CurrentSkuEntity {

                private int discount;

                private int id;

                private ListPriceEntity list_price;

                private RealPriceEntity real_price;

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
                private int score;

                public void setId(int id) {
                    this.id = id;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public int getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }

                public int getScore() {
                    return score;
                }
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
        }
    }
}
