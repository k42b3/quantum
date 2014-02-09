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

package com.k42b3.quantum.listener;

import java.sql.SQLException;
import java.util.Date;

import com.k42b3.quantum.ListenerAbstract;
import com.k42b3.quantum.Message;
import com.k42b3.quantum.WorkerAbstract;
import com.k42b3.quantum.WorkerRepository;

/**
 * RequestDateListener
 *
 * @author  Christoph Kappestein <k42b3.x@gmail.com>
 * @license http://www.gnu.org/licenses/gpl.html GPLv3
 * @link    https://github.com/k42b3/quantum
 */
public class RequestDateListener extends ListenerAbstract
{
	protected WorkerRepository workerRepository;

	public RequestDateListener(WorkerRepository workerRepository)
	{
		this.workerRepository = workerRepository;
	}

	public void notify(WorkerAbstract source, Message message)
	{
		try
		{
			workerRepository.updateRequestDate(source.getWorker(), new Date());
		}
		catch(SQLException e)
		{
			logger.error(message, e);
		}
	}
}
