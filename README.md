# DockerCon 2021 Demos

This repo contains the source material for my DockerCon 2021 talk. I hope you enjoy!

## What this is demonstrating

The whole point of my talk was to talk about the idea of "Write Once. Configure to Deploy Anywhere." By focusing on how we configure our applications, we can take the same container image and run it in a variety of ways! This repo demonstrates three mechanisms - local, Swarm, and Kubernetes. But, it could easily be updated to include ECS and others!

## Demo Pre-reqs

Before running some of the demos, you will need to build the images:

```bash
docker build -t dc2021:backend ./project/backend
docker built -t dc2021:client ./project/client
```

## Demo Material

1. [0-env-var-leak](./0-env-var-leak) - a small demo showing off a leak of environment variables. To run, simply run:
  
    ```bash
    docker compose up
    ```

    And then open [http://localhost](http://localhost). You should see a "php info" screen that will display the environment variables containing sensitive material (`DB_PASSWORD`, etc.).

1. [1-running-locally](./1-running-locally) - this demo will run the container images locally, demonstrating how you can configure both the backend and client when running locally. In this case, the Mongo database is local as well. All config files are simply being mounted into the containers.

1. [2-running-in-swarm](./2-running-in-swarm) - in this demo, we enroll local config files into the cluster and then launch the app. Before launching the stack, you'll want to tweak both the `config.json` and `application.properties` files so they point to the correct domains (wherever those might be). This demo still uses a local-to-the-cluster Mongo container.

1. [3-running-in-k8s](./3-running-in-k8s) - in this demo, we pretty much do the same thing as the Swarm demo. The only difference is that we are going to use an external Mongo database (I demoed using the Mongo Atlas service). Before deploying, update the `application.properties` and `config.json` files to use the expected domains. This demo also assumes you already have an Ingress controller up and running.

    To run, you can use the `kustomization.yaml` file to deploy everything in one step...

    ```bash
    kubectl apply -k ./3-running-in-k8s
    ```

    And when you're done, tear it down with:

    ```bash
    kubectl delete -k ./3-running-in-k8s
    ```

## License

You're welcome to use anything and everything here! Let me know if you have any questions and/or feedback!