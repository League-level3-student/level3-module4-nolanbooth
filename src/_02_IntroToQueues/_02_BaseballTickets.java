/*
 * Copyright (c) 2020, <GiacomoSorbi> All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _02_IntroToQueues;

import java.util.ArrayDeque;

/*
 * Complete the calculateWaitTime() method here!
 * Instructions are in the BaseBallTicketsTest class.
 */

public class _02_BaseballTickets {

	public static int calculateWaitTime(ArrayDeque<Integer> ticketsQueue, int position) {
		// [2, 5, 3, 6, 4]
		// [1, 5, 3, 6, 4]
		// [5, 3, 6, 4, 1]
		// decrease first value by one
		// remove it from the list
		// add the same value to the back of the list (maybe use temporary variable)
		int pos = position;
		int minutes = 0;
		// one cycle:

		while (true) {
			if (pos == 0) {
				// if position is equal to 0 of our ticket guy
				if (ticketsQueue.peek() != 1) {
					// if the position is 0, and value is not 1, then set pos equal to ticketsqueue
					// size -1
					int temp = ticketsQueue.remove() - 1;
					ticketsQueue.add(temp);
					minutes++;
					pos = ticketsQueue.size() - 1;

				} else if (ticketsQueue.peek() == 1) {
					// if position is 0, and value is 1, then return minutes
					ticketsQueue.remove();
					minutes++;
					return minutes;
				}
			} else if (pos != 0) {
				// if ticket guy is not in the first position
				if (ticketsQueue.peek() != 1) {
					// if the guy at the front still needs a few more tickets, send him to back,
					// subtract number, and add minutes, subtract pos
					int temp = ticketsQueue.remove() - 1;
					ticketsQueue.add(temp);
					pos--;
					minutes++;
				} else if (ticketsQueue.peek() == 1) {
					// if position is not 0, and our guy isn't at the front, but the guy at front
					// has 1 ticket, delete him, add minute, sub position
					ticketsQueue.remove();
					minutes++;
					pos--;

				}

			}
		}
//end}

	}
}
