/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.xdd.blackscience.socksserver.proxy;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.socks.SocksInitRequestDecoder;
import io.netty.handler.codec.socks.SocksMessageEncoder;


/**
 * Socks 协议连接的统一处理类
 * */
public final class SocksServerInitializer extends ChannelInitializer<SocketChannel> {

    private final SocksMessageEncoder socksMessageEncoder = new SocksMessageEncoder();
    private final SocksServerHandler socksServerHandler = new SocksServerHandler();

    @Override
    public void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline p = socketChannel.pipeline();
        /**
         * Socks request 解码
         * */
        p.addLast(new SocksInitRequestDecoder());

        /**
         * socks 编码
         * */
        p.addLast(socksMessageEncoder);

        /**
         * 数据处理
         * */
        p.addLast(socksServerHandler);
    }
}
