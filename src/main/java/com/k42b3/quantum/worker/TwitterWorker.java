/**
 * Quantum is an aggregator service which collects messages from different 
 * sources and publish them through an REST API.
 * 
 * Copyright (c) 2014 Christoph Kappestein <k42b3.x@gmail.com>
 * 
 * This file is part of Quantum. Quantum is free software: you can 
 * redistribute it and/or modify it under the terms of the GNU 
 * General Public License as published by the Free Software Foundation, 
 * either version 3 of the License, or at any later version.
 * 
 * Quantum is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Quantum. If not, see <http://www.gnu.org/licenses/>.
 */

package com.k42b3.quantum.worker;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;

import com.k42b3.quantum.Queue;
import com.k42b3.quantum.Worker;

/**
 * Worker which connects to the twitter API and redirect all tweets into the 
 * queue
 *
 * @author  Christoph Kappestein <k42b3.x@gmail.com>
 * @license http://www.gnu.org/licenses/gpl.html GPLv3
 * @link    https://github.com/k42b3/quantum
 */
public class TwitterWorker extends HttpWorkerAbstract
{
	public TwitterWorker(Queue queue, Worker worker)
	{
		super(queue, worker);
	}

	@Override
	protected void fetch(HttpClient httpClient)
	{
		// @TODO implement
	}

	@Override
	public Map<String, String> getParameters()
	{
		LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
		parameters.put("consumer_key", "Consumer key");
		parameters.put("consumer_secret", "Consumer secret");
		parameters.put("token", "Token");
		parameters.put("token_secret", "Token secret");

		return parameters;
	}
}
