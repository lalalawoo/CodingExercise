*Learning Kubernetes*

**create Job**

apiVersion: batch/v1
kind: Job
metadata:
  name: myjob
spec:
  completions: 4
  parallelism: 6
  template:
    metadata:
      name: beijing
    spec:
      containers:
      - name: beijing-container
        image: perl
        command: ["perl", "-wle", "print \'Beijing\'"]
      restartPolicy: Never
  backoffLimit: 3
