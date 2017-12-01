```java 
kubectl create secret generic q15secret --from-literal=password=123

apiVersion: v1
kind: Pod
metadata:
  name: pod-q15-volume
spec:
  containers:
  - name: pod-volume
    image: nginx
    volumeMounts:
    - name: vol
      mountPath: /path
  volumes:
  - name: vol
    secret:
      secretName: q15secret 
```
