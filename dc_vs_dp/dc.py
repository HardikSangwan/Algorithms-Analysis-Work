import os
import time
from os import listdir
from os.path import isfile, join
import sys


class divide_and_conquer(object):
    def __init__(self):
        self.day_arr = []
        self.data_files = []
        

    def load_file_data(self,input_path):
        self.data_files = [file for file in listdir(input_path) if '.txt' in file and isfile(join(input_path, file))]


    def load_day_data(self,file_name):

        with open(file_name) as file:
            info = [line.strip('\n') for line in file.readlines()]
            temp = info[0].split(',')
            n, k = int(temp[0]), int(temp[1])

            for i in range(1,k+1,1):
                temp = info[i].split(',')
                days = [float(rate) for rate in temp]
                self.day_arr.append(days)
        

    def get_max_overlapping_arr(self,nums,start,end,middle):
        sum_val = 0
        left_sum = -sys.maxsize-1
        right_sum = -sys.maxsize-1
        start_i = 0
        end_i = 0

        for i in range(middle,-1,-1):
            sum_val += nums[i]
            if sum_val >= left_sum:
                left_sum = sum_val
                start_i = i

        sum_val = 0
        for i in range(middle+1,end+1,1):
            sum_val += nums[i]
            if sum_val >= right_sum:
                right_sum = sum_val
                end_i = i

        return left_sum+right_sum, start_i, end_i


    def get_max_sum_arr(self,nums,start,end):
        if start == end:
            return nums[end],start,end

        middle = int((start+end)/2)
        left_sum, left_start, left_end = self.get_max_sum_arr(nums,start,middle)
        right_sum, right_start, right_end = self.get_max_sum_arr(nums,middle+1,end)
        overlapping_sum, cross_start, cross_end = self.get_max_overlapping_arr(nums,start,end,middle)

        i = 0
        j = 0
        max_sum = 0

        if left_sum > right_sum:
            i = left_start
            j = left_end
            max_sum = left_sum
        else:
            i = right_start
            j = right_end
            max_sum = right_sum

        if overlapping_sum > max_sum:
            i = cross_start
            j = cross_end
            max_sum = overlapping_sum

        return max_sum,i,j


    def save_output(self,file_name,data):
        file_name = 'output/hsangwan3_output_dc_' + file_name

        with open(file_name,'w') as file:
            for i in range(len(data)):
                file.write(data[i])
                if i < len(data)-1:
                    file.write('\n')


    def run_dc(self):
        path = os.path.join(os.path.dirname(__file__), 'data/')
        self.load_file_data(path)

        avg_arr = []
        for file in self.data_files:
            self.load_day_data('data/'+file)
            output = []
            start_t = time.time() * 1000
            print()
            print("Running DC Algorithm for file "+file)
            for day in self.day_arr:
                start_time = time.time() * 1000
                val,i,j = self.get_max_sum_arr(day,0,len(day)-1)
                exec_time = (time.time() * 1000) - start_time
                val = "%.2f" % val
                exec_time = "%.2f" % exec_time

                out_str = val + ',' + str(i+1) + ',' + str(j+1) + ',' + exec_time
                output.append(out_str)
            exec_t = ((time.time()*1000) - start_t)/10
            exec_t = "%.2f" % exec_t
            print("Finished running DP Algorithm for "+file+" in "+exec_t+" milliseconds")
            print()

            self.save_output(file,output)
            self.day_arr = []
            

if __name__ == '__main__':
    dc = divide_and_conquer()
    dc.run_dc()