
#Introduction 

   In this Linux_SQl project, some data/information will be stored and they will have generated the reports for the future. The data which is called hardware specifications will be recorded. Secondly, the data which is called node/resources/server(CPU/Memory) will be monitored. Later on, collected data will have been stored in RDBMS. In order to do that, three different servers/nodes will be set up, each node is going to be linked through an internal connection to switch. Bash agent will collect server usage data and then bash gent will insert them into the PSQL instance. In order to do that, it will have two main bash scripts host_info.sh and host_usage.sh, Basic steps are listed below.
  - Creation of postgreSQL instance,
  - Database Tables,
  - Collect hardware specifications for each server,
  - Monitoring node/server resources(Cpu/Memory),
  - To store the collected data on RDBMS,
  - To manage the data needs.
The technologies that will be used;
  - Git/Github/GitFlow,
  - Bash,
  - Docker,
  - PostgreSQL,
  - DDL (Data Definition Language),
  - DML (Data Maniplulation Language).

#Quick Start

    Create PSQL instance;
        `-/scripts/psql_docker.sh  start`
     Create Table;
        `psql -h localhost -U postgres -d host_agent -f sql/ddl.sql`
     Hardware specification Database
        `bash scripts/host_info.sh localhost 5432 host_agent postgres password`
    Node/Server Resources(CPU/Memory) Database
        `bash scripts/host_usage.sh localhost 5432 host_agent postgres password`
     The process of Contrab
        Step 1 = Contrab edition
                `contrab -e`
        Step 2 = Contrab addition
        
#Implementaion 

     During Linux-SQL project
   - Created SQL instance by using ` psql_docker.sh`
   - Created `host_agent` database in psql instance,` host_agent` has two tables,` host_info` table contains hardware specifications, `host_usage` table contains monitor resource usage data.
   -` Monitoring_agent` phase, in that phase, `bash_agent` will be run directly for two tables as well as `host_usage.sh` will work every minute due to the Crontab package using.
   
   
#Architecture

The diagram is located on asset folder.


#Scripts 

  ` psql_docker.sh` is to create /start/stop psql container
        `-/scripts/psql_docker.sh  start/stop/create`
    `host_info.sh` is a script to add the hardware specification to the psql instance.
        `bash scripts/host_info.sh psql_host psql_post DB_name psql_user psql_password`
   `host_usage.sh` is a script to add resource usage data to the psql instance
    Crontab : it is a script to run `host_usage.sh` every minute
        ` * * * * * bash/ home/centos/dev/jrvs/bootcamp/linux_sql/host_agent/scripts/host_usage.sh localhost 5432 host_agent postgres password > /tmp/host_usage.log `
        `crontab -l`
        
#Database Modelling 

        -` host_info`
                id = PK
                hostname = hostname
                cpu_number = The number of CPU
                cpu_architecture = Processor
                cpu_model = The model of CPU
               cpu_mhz =  CPU speed
                L2_cache = Cache memory in the level two
                total_mem = Total memory
                timestamp = UTC time value
                
        - `host_usage`
                timestamp = UTC Time value
                host_id = PK
                memory_free = The rest of the free memory
                cpu_idle = Idle time
                cpu_kernel = Kernel time
                disk_io = The amount of disk
                disk_available = Suitable disk amount (MB)
                

#Test


    On the condition that there is an error, the terminal will be controlled in order to clarify the error. Based on the name of the error style and its visible location will have estimated. Finally, the error will have been fixed, and regenerate the program.
    

#Deployment

The project has been deployed in Github applying each ticket of the sprint, In this Linux-SQL project, there were eight tickets which are implementation tickets, based on the spring schedule, each ticket implementation has its own branch name and each branch was merged into develop branch.

#Improvements

    - Handle  hardware updates,
    - RDBMS/SQL, POSTGRESQL,
    - The necessity of Time management in the real-time project,
    - The importance of using the different branches in GitFlow and Github.
    - Team collaboration,
    - Agile techniques with implementations.


