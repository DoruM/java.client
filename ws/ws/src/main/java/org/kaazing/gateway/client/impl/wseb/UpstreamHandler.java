/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.gateway.client.impl.wseb;

import org.kaazing.gateway.client.impl.http.HttpRequestHandler;
import org.kaazing.gateway.client.util.WrappedByteBuffer;

interface UpstreamHandler {

    void setListener(UpstreamHandlerListener upstreamHandlerListener);
    void processOpen(UpstreamChannel channel);
    void processClose(UpstreamChannel upstreamChannel, int code, String reason);
    void processTextMessage(UpstreamChannel upstreamChannel, String message);
    void processBinaryMessage(UpstreamChannel upstreamChannel, WrappedByteBuffer message);
    void setNextHandler(HttpRequestHandler nextHandler);
    void processPong(UpstreamChannel upstreamChannel);
}
