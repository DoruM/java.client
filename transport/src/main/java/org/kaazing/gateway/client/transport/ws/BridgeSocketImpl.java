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
package org.kaazing.gateway.client.transport.ws;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

import javax.net.ssl.SSLSocketFactory;

class BridgeSocketImpl implements BridgeSocket {

    boolean secure;
    Socket socket;
    
    BridgeSocketImpl(boolean secure) {
        this.secure = secure;
    }

    @Override
    public void connect(InetSocketAddress inetSocketAddress, long timeout) throws IOException {
        if (secure) {
            socket = SSLSocketFactory.getDefault().createSocket();
        }
        else {
            socket = new Socket();
        }


        assert(timeout >= 0);
        socket.connect(inetSocketAddress, (int)timeout);
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return socket.getOutputStream();
    }

    @Override
    public void setKeepAlive(boolean val) throws SocketException {
        socket.setKeepAlive(val);
    }

    @Override
    public void setSoTimeout(int timeout) throws SocketException {
        socket.setSoTimeout(timeout);
    }
}
