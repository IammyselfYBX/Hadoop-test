package com.hadoop.service.impl;

public class VideoBehavior {
        /**
         *视频行为的属性
         */
        private int startTime;
        private int endTime;
        private double speed;
        public int getStartTime() {
        	return startTime;
        }
        public void setStartTime(int startTime) {
        	this.startTime = startTime;
        }
        public int getEndTime() {
                return endTime;
        }
        public void setEndTime(int endTime) {
                this.endTime = endTime;
        }
        public double getSpeed() {
                return speed;
        }
        public void setSpeed(double speed) {
                this.speed = speed;
        }


}
