/*
 * Copyright(c) 2020 RELapps (https://relapps.net)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.relapps.ptrac.client.gs;

/**
 * Serialization of a time record.
 *
 * @author RMT
 */
public class GsTimeRecord extends GsObject {

    public String getComment() {
        return comment;
    }

    public String getCommentExp() {
        return commentExp;
    }

    public String getDate() {
        return date;
    }

    public String getProjectOid() {
        return projectOid;
    }

    public GsTime getTime() {
        return time;
    }

    public String getUserOid() {
        return userOid;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentExp(String commentExp) {
        this.commentExp = commentExp;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public void setProjectOid(String projectOid) {
        this.projectOid = projectOid;
    }

    public void setTime(GsTime time) {
        this.time = time;
    }

    public void setUserOid(String userOid) {
        this.userOid = userOid;
    }
    private String comment;
    private String commentExp;
    private String date;
    private boolean frozen;
    private String projectOid;
    private GsTime time;
    private String userOid;
}
