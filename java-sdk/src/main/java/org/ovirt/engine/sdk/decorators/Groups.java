//
// Copyright (c) 2012 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//           http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

// *********************************************************************
// ********************* GENERATED CODE - DO NOT MODIFY ****************
// *********************************************************************

package org.ovirt.engine.sdk.decorators;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.common.CollectionDecorator;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.CollectionUtils;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlHelper;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;
import org.ovirt.engine.sdk.entities.Action;

/**
 * Groups decorator.
 */
@SuppressWarnings("unused")
public class Groups extends
        CollectionDecorator<org.ovirt.engine.sdk.entities.Group, 
                            org.ovirt.engine.sdk.entities.Groups, 
                            Group> {

    /**
     * @param proxy HttpProxyBroker
     */
    public Groups(HttpProxyBroker proxy) {
        super(proxy, "groups");
    }

    /**
     * Lists Group objects.
     *
     * @return
     *     List of {@link Group }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    @Override
    public List<Group> list() throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName();
        return list(url, org.ovirt.engine.sdk.entities.Groups.class, Group.class);
    }

    /**
     * Fetches Group object by id.
     *
     * @return {@link Group }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    @Override
    public Group get(UUID id) throws ClientProtocolException,
            ServerException, IOException {
        String url = SLASH + getName() + SLASH + id.toString();
        return getProxy().get(url, org.ovirt.engine.sdk.entities.Group.class, Group.class);
    }

    /**
     * Adds Group object.
     *
     * @param group
     *
     * <pre>
     * group.name
     * </pre>
     *
     * @return
     *     {@link Group }
     *
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws IOException
     */
    public Group add(org.ovirt.engine.sdk.entities.Group group) throws 
            ClientProtocolException, ServerException, IOException {
        String url = SLASH + getName();
        return getProxy().add(url, group, org.ovirt.engine.sdk.entities.Group.class, Group.class);
    }

}

