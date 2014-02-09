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

package com.k42b3.quantum;

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * A worker gathers all new informations from an resource and pushes the 
 * messages into an queue
 *
 * @author  Christoph Kappestein <k42b3.x@gmail.com>
 * @license http://www.gnu.org/licenses/gpl.html GPLv3
 * @link    https://github.com/k42b3/quantum
 */
abstract public class WorkerAbstract implements Runnable
{
	protected Queue queue;
	protected Worker worker;

	protected Logger logger = Logger.getLogger("com.k42b3.quantum");

	public WorkerAbstract(Queue queue, Worker worker)
	{
		this.queue = queue;
		this.worker = worker;
	}
	
	public Queue getQueue()
	{
		return queue;
	}
	
	public Worker getWorker()
	{
		return worker;
	}

	public boolean needsOwnThread()
	{
		return false;
	}
	
	abstract public Map<String, String> getParameters();
}
