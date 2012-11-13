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

package org.ovirt.engine.sdk.web;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.ovirt.engine.sdk.exceptions.ServerException;
import org.ovirt.engine.sdk.utils.Mapper;
import org.ovirt.engine.sdk.utils.SerializationHelper;
import org.ovirt.engine.sdk.utils.UrlHelper;

/**
 * Provides broker capabilities over HttpProxy
 */
public class HttpProxyBroker {

    private HttpProxy proxy;
    private UrlHelper urlHelper;

    /**
     * @param proxy
     *            HttpProxy to encapsulate
     */
    public HttpProxyBroker(HttpProxy proxy) {
        this.proxy = proxy;
        this.urlHelper = new UrlHelper(proxy.getUrl());
    }

    /**
     * updates resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return updated resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T update(String url, F entity, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return update(url, entity, from, to, null);
    }

    /**
     * updates resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param from
     *            from type
     * @param to
     *            to type
     * @param headers
     *            HTTP headers
     * 
     * @return updated resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T update(String url, F entity, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpPut httpput = new HttpPut(this.urlHelper.combine(url));

        String xmlReq = SerializationHelper.marshall(from, entity);
        HttpEntity httpentity = new StringEntity(xmlReq);
        httpput.setEntity(httpentity);

        String xmlRes = this.proxy.execute(httpput, headers, null);
        F res = SerializationHelper.unmarshall(from, xmlRes);

        return Mapper.map(res, to, this);
    }

    /**
     * Performs action on a resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return action response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T action(String url, F entity, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return add(url, entity, from, to, null);
    }

    /**
     * Performs action on a resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            resource
     * @param from
     *            from type
     * @param to
     *            to type
     * @param headers
     *            HTTP headers
     * 
     * @return action response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T action(String url, F entity, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return add(url, entity, from, to, headers);
    }

    /**
     * Adds new resource
     * 
     * @param url
     *            collection url
     * @param entity
     *            entity to add
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return added resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T add(String url, F entity, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return add(url, entity, from, to, null);
    }

    /**
     * Adds new resource
     * 
     * @param url
     *            collection url
     * @param entity
     *            entity to add
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @param headers
     *            HTTP headers
     * 
     * @return added resource
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T add(String url, F entity, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpPost httpost = new HttpPost(this.urlHelper.combine(url));

        String xmlReq = SerializationHelper.marshall(from, entity);
        HttpEntity httpentity = new StringEntity(xmlReq);
        httpost.setEntity(httpentity);

        String xmlRes = this.proxy.execute(httpost, headers, null);
        return SerializationHelper.unmarshall(to, xmlRes);
    }

    /**
     * Deletes resource
     * 
     * @param url
     *            resource url
     * @param to
     *            to typr
     * 
     * @return response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T delete(String url, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return delete(url, null, null, to, null);
    }

    /**
     * Deletes resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            entity to pass
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T delete(String url, F entity, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return delete(url, entity, from, to, null);
    }

    /**
     * Deletes resource
     * 
     * @param url
     *            resource url
     * @param entity
     *            entity to pass
     * @param from
     *            from type
     * @param to
     *            to type
     * @param headers
     *            HTTP headers
     * 
     * @return response
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T delete(String url, F entity, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpDelete httdelete = new HttpDelete(this.urlHelper.combine(url));
        if (entity != null && from != null) {
            // TODO: inject entity to DELETE request
            // String xmlReq = SerializationHelper.marshall(from, entity);
            // HttpEntity httpentity = new StringEntity(xmlReq);
            // httdelete.setEntity(httpentity);
        }
        String xmlRes = this.proxy.execute(httdelete, headers, null);
        return SerializationHelper.unmarshall(to, xmlRes);
    }

    /**
     * Fetches resource
     * 
     * @param url
     *            entity url
     * @param from
     *            from type
     * @param to
     *            to type
     * @param headers
     *            HTTP headers
     * 
     * @return entity
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T get(String url, Class<F> from, Class<T> to, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpGet httpget = new HttpGet(this.urlHelper.combine(url));
        String xmlRes = this.proxy.execute(httpget, headers, null);

        return unmarshall(from, to, xmlRes);
    }

    /**
     * Fetches resource
     * 
     * @param url
     *            entity url
     * @param from
     *            from type
     * @param to
     *            to type
     * 
     * @return entity
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public <F, T> T get(String url, Class<F> from, Class<T> to)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return get(url, from, to, null);
    }

    /**
     * Fetches resource
     * 
     * @param url
     *            entity url
     * 
     * @return entity XML representation
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public String get(String url)
            throws IOException, ClientProtocolException, ServerException, JAXBException {
        return get(url, null);
    }

    /**
     * Fetches resource
     * 
     * @param url
     *            entity url
     * @param headers
     *            HTTP headers
     * 
     * @return entity
     * 
     * @throws IOException
     * @throws ClientProtocolException
     * @throws ServerException
     * @throws JAXBException
     */
    public String get(String url, List<Header> headers)
            throws IOException, ClientProtocolException, ServerException, JAXBException {

        HttpGet httpget = new HttpGet(this.urlHelper.combine(url));
        return this.proxy.execute(httpget, headers, null);
    }

    /**
     * Unmarshales item from the xml
     * 
     * @param from
     *            entity type
     * @param to
     *            decorator type
     * @param xml
     *            xml object representation
     * 
     * @return decorator
     * 
     * @throws JAXBException
     */
    private <F, T> T unmarshall(Class<F> from, Class<T> to, String xml) throws JAXBException {
        F res = SerializationHelper.unmarshall(from, xml);
        return Mapper.map(res, to, this);
    }

    /**
     * Enable/Disable client permissions based filtering (default is False)
     * 
     * @param filter
     */
    public void setFilter(boolean filter) {
        this.proxy.setFilter(filter);
    }

    /**
     * Enable/Disable debug mode (default is False)
     * 
     * @param debug
     */
    public void setDebug(boolean debug) {
        this.proxy.setDebug(debug);
    }

    /**
     * Enable/Disable accessing SSL sites without validating host identity (default is False)
     * 
     * @param insecure
     */
    public void setInsecure(boolean insecure) {
        this.proxy.setInsecure(insecure);
    }

    /**
     * Enable/Disable persistent authentication (default is True)
     * 
     * @param persistentAuth
     */
    public void setPersistentAuth(boolean persistentAuth) {
        this.proxy.setPersistentAuth(persistentAuth);
    }

    /**
     * @return persistent authentication flag
     */
    public boolean isPersistentAuth() {
        return this.proxy.isPersistentAuth();
    }

    /**
     * @return Insecure flag
     */
    public boolean isInsecure() {
        return this.proxy.isInsecure();
    }

    /**
     * @return Filter flag
     */
    public boolean isFilter() {
        return this.proxy.isFilter();
    }

    /**
     * @return Debug flag
     */
    public boolean isDebug() {
        return this.proxy.isDebug();
    }

    /**
     * @return oVirt API root resource URL
     */
    public String getRoot() {
        return this.urlHelper.getRoot();
    }
}
