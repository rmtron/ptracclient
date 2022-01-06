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
 * Serialization of a project.
 *
 * @author RMT
 */
public class GsProject extends GsObject {

    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public GsProject[] getChildren() {
        return children;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public int getNumUsage() {
        return numUsage;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentOid() {
        return parentOid;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isPto() {
        return pto;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public void setChildren(GsProject[] children) {
        this.children = children;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public void setNumUsage(int numUsage) {
        this.numUsage = numUsage;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public void setParentOid(String parentOid) {
        this.parentOid = parentOid;
    }

    public void setPto(boolean pto) {
        this.pto = pto;
    }
    private boolean active;
    private GsProject[] children;
    private String dateCreated;
    private String dateModified;
    private String description;
    private String name;
    private String note;
    private int numChildren;
    private int numUsage;
    private String parentName;
    private String parentOid;
    private boolean pto;
}
