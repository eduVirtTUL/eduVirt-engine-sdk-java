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

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.ovirt.engine.sdk.entities.Action;
import org.ovirt.engine.sdk.entities.Response;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.HttpHeaderBuilder;
import org.ovirt.engine.sdk.utils.HttpHeaderUtils;
import org.ovirt.engine.sdk.utils.UrlBuilder;
import org.ovirt.engine.sdk.web.HttpProxyBroker;
import org.ovirt.engine.sdk.web.UrlParameterType;

/**
 * <p>OpenStackVolumeProvider providing relation and functional services
 * <p>to {@link org.ovirt.engine.sdk.entities.OpenStackVolumeProvider }.
 */
@SuppressWarnings("unused")
public class OpenStackVolumeProvider extends
        org.ovirt.engine.sdk.entities.OpenStackVolumeProvider {

    private HttpProxyBroker proxy;
    private final Object LOCK = new Object();

    private volatile OpenStackVolumeProviderCertificates openStackVolumeProviderCertificates;
    private volatile OpenStackVolumeProviderOpenStackVolumeTypes openStackVolumeProviderOpenStackVolumeTypes;


    /**
     * @param proxy HttpProxyBroker
     */
    public OpenStackVolumeProvider(HttpProxyBroker proxy) {
        this.proxy = proxy;
    }

    /**
     * @return HttpProxyBroker
     */
    private HttpProxyBroker getProxy() {
        return proxy;
    }

    /**
     * Gets the value of the OpenStackVolumeProviderCertificates property.
     *
     * @return
     *     {@link OpenStackVolumeProviderCertificates }
     */
    public OpenStackVolumeProviderCertificates getCertificates() {
        if (this.openStackVolumeProviderCertificates == null) {
            synchronized (this.LOCK) {
                if (this.openStackVolumeProviderCertificates == null) {
                    this.openStackVolumeProviderCertificates = new OpenStackVolumeProviderCertificates(proxy, this);
                }
            }
        }
        return openStackVolumeProviderCertificates;
    }
    /**
     * Gets the value of the OpenStackVolumeProviderOpenStackVolumeTypes property.
     *
     * @return
     *     {@link OpenStackVolumeProviderOpenStackVolumeTypes }
     */
    public OpenStackVolumeProviderOpenStackVolumeTypes getOpenStackVolumeTypes() {
        if (this.openStackVolumeProviderOpenStackVolumeTypes == null) {
            synchronized (this.LOCK) {
                if (this.openStackVolumeProviderOpenStackVolumeTypes == null) {
                    this.openStackVolumeProviderOpenStackVolumeTypes = new OpenStackVolumeProviderOpenStackVolumeTypes(proxy, this);
                }
            }
        }
        return openStackVolumeProviderOpenStackVolumeTypes;
    }


    /**
     * Deletes object.
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete(Boolean async) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Deletes object.
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @param async
     *    <pre>
     *    [true|false]
     *    </pre>
     *
     * @return
     *     {@link Response }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Response delete(Boolean async, String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        if (async != null) {
            urlBuilder.add("async", async, UrlParameterType.MATRIX);
        }

        url = urlBuilder.build();

        return getProxy().delete(url, Response.class, headers);
    }
    /**
     * Performs importcertificates action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action importcertificates(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/importcertificates";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Performs testconnectivity action.
     *
     * @param action {@link org.ovirt.engine.sdk.entities.Action}
     * @return
     *     {@link Action }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public Action testconnectivity(Action action) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref() + "/testconnectivity";

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().action(url, action, Action.class, Action.class, headers);
    }
    /**
     * Updates OpenStackVolumeProvider object.
     *
     * @param openstackvolumeprovider {@link org.ovirt.engine.sdk.entities.OpenStackVolumeProvider}
     *    <pre>
     *    [openstack_volume_provider.name]
     *    [openstack_volume_provider.description]
     *    [openstack_volume_provider.data_center.id|name]
     *    [openstack_volume_provider.requires_authentication]
     *    [openstack_volume_provider.username]
     *    [openstack_volume_provider.password]
     *    [openstack_volume_provider.authentication_url]
     *    [openstack_volume_provider.properties.property]
     *    </pre>
     *
     * @return
     *     {@link OpenStackVolumeProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public OpenStackVolumeProvider update() throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.OpenStackVolumeProvider.class,
                OpenStackVolumeProvider.class,
                headers);
    }
    /**
     * Updates OpenStackVolumeProvider object.
     *
     * @param openstackvolumeprovider {@link org.ovirt.engine.sdk.entities.OpenStackVolumeProvider}
     *    <pre>
     *    [openstack_volume_provider.name]
     *    [openstack_volume_provider.description]
     *    [openstack_volume_provider.data_center.id|name]
     *    [openstack_volume_provider.requires_authentication]
     *    [openstack_volume_provider.username]
     *    [openstack_volume_provider.password]
     *    [openstack_volume_provider.authentication_url]
     *    [openstack_volume_provider.properties.property]
     *    </pre>
     *
     * @param correlationId
     *    <pre>
     *    [any string]
     *    </pre>
     *
     * @return
     *     {@link OpenStackVolumeProvider }
     *
     * @throws ClientProtocolException
     *             Signals that HTTP/S protocol error has occurred.
     * @throws ServerException
     *             Signals that an oVirt api error has occurred.
     * @throws IOException
     *             Signals that an I/O exception of some sort has occurred.
     */
    public OpenStackVolumeProvider update(String correlationId) throws ClientProtocolException,
            ServerException, IOException {
        String url = this.getHref();

        HttpHeaderBuilder headersBuilder = new HttpHeaderBuilder();
        if (correlationId != null) {
            headersBuilder.add("Correlation-Id", correlationId);
        }
        List<Header> headers = headersBuilder.build();

        UrlBuilder urlBuilder = new UrlBuilder(url);
        url = urlBuilder.build();

        return getProxy().update(
                url,
                this,
                org.ovirt.engine.sdk.entities.OpenStackVolumeProvider.class,
                OpenStackVolumeProvider.class,
                headers);
    }

}
