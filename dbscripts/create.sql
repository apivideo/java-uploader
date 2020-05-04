CREATE TABLE admins (
    id      SERIAL PRIMARY KEY,
    api_key TEXT UNIQUE NOT NULL
);

CREATE TABLE videos (
    id         SERIAL PRIMARY KEY,
    unique_url TEXT NOT NULL,
    client_tag TEXT NOT NULL
);

CREATE TABLE video_client_admin_relationships (
    admin_id INTEGER REFERENCES admins,
    video_id INTEGER REFERENCES videos
)



