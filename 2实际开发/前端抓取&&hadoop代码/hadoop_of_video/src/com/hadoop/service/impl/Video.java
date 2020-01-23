package com.hadoop.service.impl;

public class Video {
        /**
         * 视频所需的属性
         */
        private int id;
        private String url;
        private double length;
        public int getId() {
                return id;
        }
        public void setId(int id) {
                this.id = id;
        }
        public String getUrl() {
                return url;
        }
        public void setUrl(String url) {
                this.url = url;
        }
        public double getLength() {
                return length;
        }
        public void setLength(double length) {
                this.length = length;
        }


}
