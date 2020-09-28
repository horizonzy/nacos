/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.nacos.naming.pojo;

import com.alibaba.nacos.naming.core.Instance;

import java.util.List;

/**
 * InstanceOperationContext. used in instance batch operation's consumer.
 *
 * @author horizonzy
 */
public class InstanceOperationContext {
    
    private String namespace;
    
    private String serviceName;
    
    private Boolean ephemeral;
    
    private Boolean all;
    
    private List<Instance> instances;
    
    public String getNamespace() {
        return namespace;
    }
    
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    
    public String getServiceName() {
        return serviceName;
    }
    
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    public Boolean getEphemeral() {
        return ephemeral;
    }
    
    public void setEphemeral(Boolean ephemeral) {
        this.ephemeral = ephemeral;
    }
    
    public Boolean getAll() {
        return all;
    }
    
    public void setAll(Boolean all) {
        this.all = all;
    }
    
    public List<Instance> getInstances() {
        return instances;
    }
    
    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }
    
    /**
     * to operate all ephemeral instances from consitencyService.
     */
    public void allEphemeralOperate() {
        this.all = true;
        this.ephemeral = true;
    }
    
    /**
     * to operate all persist instances from consitencyService.
     */
    public void allPersistOperate() {
        this.all = true;
        this.ephemeral = false;
    }
    
    /**
     * to operate locate instances from consistencySercice judged by ephemeral.
     *
     * @param ephemeral ephemeral
     * @param instances need located instances.
     */
    public void locateInstanceOperate(Boolean ephemeral, List<Instance> instances) {
        this.all = false;
        this.ephemeral = ephemeral;
        this.instances = instances;
    }
}
