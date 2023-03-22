# CS415: Virtual Memory Lab

<h3>Learning Goals</h3>
This lab aims to teach how virtual memory works and how to develop a complex algorithm into a real program.

<h3>Program Description</h3>
This program is a virtual memory simulator that takes memory address traces as input and simulates swapping pages into and out of memory to determine the number of memory accesses that went to a page in memory, missed, and compulsory misses. It keeps track of total memory accesses, hits, misses, and compulsory misses.

<h3>Virtual Memory Configuration</h3>
The simulator is configured with 16-bit memory addresses, 6-bit page table index, and 10-bit page offset. Each process has 64 Page Table Entries, and the page size is 1 KB (1024 bytes). It has 30 page frames for memory, and the replacement algorithm is a round-robin replacement algorithm. The memory is filled starting from page frame 0, going until page frame 29, and then wrapping around. The next page frame to replace is page frame 0, followed by 1, 2, 3, and so on until page frame 29. After that, it wraps around again and replaces page frame 0.
