#!/bin/sh
for k in $(seq 1 100)
do
				java Test
				java Test1
				java Test2
				java Test3
				java Test4
				java Test5
				java Test6
				mkdir /home/tony/hadoop_test1/test_${k}
				mv /home/tony/hadoop_test1/output* /home/tony/hadoop_test1/test_${k}
done
