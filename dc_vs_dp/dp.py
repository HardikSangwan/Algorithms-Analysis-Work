import os
import time
from os import listdir
from os.path import isfile, join

class dynamic_programming(object):
    def __init__(self):
        #Initialization
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
        

    def get_max_arr(self,nums):
        # Dynamic Programming Algorithm for calculating max sum from continguous sub-array
        max_curr = nums[0]
        max_tot = nums[0]
        start = 0
        end = 0
        temp = 0

        for i in range(1,len(nums)):
            if nums[i] >= max_curr+nums[i]:
                temp = i
            max_curr = max(nums[i],max_curr+nums[i])
            if max_curr >= max_tot:
                start = temp
                end = i
            max_tot = max(max_tot,max_curr)

        return max_tot,start,end


    def save_output(self,file_name,data):

        file_name = 'output/hsangwan3_output_dp_' + file_name

        with open(file_name,'w') as file:
            for i in range(len(data)):
                file.write(data[i])
                if i < len(data)-1:
                    file.write('\n')


    def run_dp(self):
        path = os.path.join(os.path.dirname(__file__), 'data/')
        self.load_file_data(path)

        avg_arr = []
        for file in self.data_files:
            self.load_day_data('data/'+file)
            output = []
            start_t = time.time()*1000
            print()
            print("Running DP Algorithm for "+file)
            for day in self.day_arr:
                start_time = time.time() * 1000
                val,i,j = self.get_max_arr(day)
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
    dp = dynamic_programming()
    dp.run_dp()