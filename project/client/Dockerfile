FROM node:lts-alpine AS build
WORKDIR /usr/local/app
COPY package.json yarn.lock ./
RUN yarn install --no-cache && \
    yarn cache clean
COPY public ./public
COPY src ./src
RUN yarn build

FROM nginx:alpine
RUN apk add jq
COPY ./configure-and-start.sh /usr/local/bin
COPY --from=build /usr/local/app/build /usr/share/nginx/html
ENTRYPOINT ["/usr/local/bin/configure-and-start.sh"]
CMD ["nginx", "-g", "daemon off;"]
