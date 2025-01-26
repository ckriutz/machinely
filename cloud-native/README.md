## Cloud Native Developer Codespace

Uses Java 21, Docker, local Kubernetes cluster (minikube), kubectl, Helm and Azure cli.

## Build Instructions

**To build the project**
```sh
mvn clean package 
```

**To build the project**
```sh
mvn spring-boot:run 
```

**deploy sample pod in local k8s cluster**
```sh
kubectl run nginx --image=nginx
```

**view pods in local k8s cluster**
```sh
kubectl get pods
```
**Use helm cli to validate chart**
```sh
helm lint k8s/k8sapp/
```
**Use helm cli to install chart to local cluster**
```sh
helm install k8sapp k8s/k8sapp/
```
**Use helm/kubectl cli to validate install**
```sh
helm list
kubectl get pods
```
**Use port forwarding to test traffic to pod**
```sh
kubectl port-forward pod/<POD_NAME> 8080:8080
```

**Use helm cli to uninstall chart**
```sh
helm uninstall k8sapp
```




