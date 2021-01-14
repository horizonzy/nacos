/*
 * Copyright 1999-2020 Alibaba Group Holding Ltd.
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

package com.alibaba.nacos.core.auth;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
 * Auth header util.
 *
 * @author xiweng.yy
 */
@Component
public class AuthHeaderUtil implements ApplicationContextAware {
    
    private static AuthConfigs authConfigs;
    
    public static String getServerIdentityKey() {
        return authConfigs.getServerIdentityKey();
    }
    
    public static String getServerIdentityValue() {
        return authConfigs.getServerIdentityValue();
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AuthHeaderUtil.authConfigs = applicationContext.getBean(AuthConfigs.class);
    }
}
