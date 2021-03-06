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
package org.kaazing.net.ws.amqp.impl;

import org.kaazing.net.ws.amqp.AmqpEvent;

/**
 * The Continuation class represents a callback when an asynchronous action is completed.  The callback passed
 * to an AMQP method is invoked to indicate that the action performed successfully.  When an error occurs while
 * performing the action, the error handler passed to the method is invoked instead.
 */
public interface Continuation {

    /**
     * Invoked when the associated action has been performed successfully.  
     * @param e
     */
    public void onCompleted(AmqpEvent e);
    
}
