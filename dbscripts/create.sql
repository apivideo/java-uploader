CREATE TABLE admins (
    id      SERIAL PRIMARY KEY,
    api_key TEXT UNIQUE NOT NULL
);

CREATE TABLE video_group (
    id         SERIAL PRIMARY KEY,
    unique_url TEXT UNIQUE NOT NULL,
    client_tag TEXT        NOT NULL
);

CREATE TABLE video_client_admin_relationships (
    admin_id INTEGER        NOT NULL REFERENCES admins,
    video_group_id INTEGER UNIQUE NOT NULL REFERENCES video_group
);



