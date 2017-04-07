package com.pcm.maybe.remindyou.entity;

/**
 * Created by maybe on 2017/4/5.
 */

public class RemindInfo {
    private String renmidContent;
    private String remindtime;

    public String getRenmidContent() {
        return renmidContent;
    }

    public void setRenmidContent(String renmidContent) {
        this.renmidContent = renmidContent;
    }

    public String getRemindtime() {
        return remindtime;
    }

    public void setRemindtime(String remindtime) {
        this.remindtime = remindtime;
    }


    @Override
    public String toString() {
        return "remindInfo{" +
                "renmidContent='" + renmidContent + '\'' +
                ", remindtime='" + remindtime + '\'' +
                '}';
    }
}
