# WIA1002 Smart Food Delivery System

**Course:** WIA1002 Data Structures
**Group:** 7 **Deadline:** 12 June 2026

## Members & Modules

| Member | Module | Package | Data Structures |
|--------|--------|---------|----------------|
| M1 (Leader) | User & Restaurant Management | `fooddelivery.users` `fooddelivery.app` `fooddelivery.utils` | ArrayList / LinkedList |
| M2 | Order Processing + Undo | `fooddelivery.orders` | Queue, Stack |
| M3 | Rider Assignment | `fooddelivery.riders` | Priority Queue (Min-Heap) |
| M4 | Route Finder | `fooddelivery.routes` | Graph, Dijkstra |
| M5 | Food Search & Integration | `fooddelivery.search` | BST, HashMap |

## Branch Strategy

- `main` — final submission only
- `dev` — integration branch (merge your feature branch here)
- `feature/user-restaurant` — M1
- `feature/order-queue` — M2
- `feature/rider-priority` — M3
- `feature/route-finder` — M4
- `feature/search-integration` — M5

## How to Contribute

1. Clone the repo
2. Switch to dev first:
   `git checkout dev`
3. Create YOUR branch from dev (use your exact branch name below):
   - M2 → `git checkout -b feature/order-queue`
   - M3 → `git checkout -b feature/rider-priority`
   - M4 → `git checkout -b feature/route-finder`
   - M5 → `git checkout -b feature/search-integration`
4. Code your module inside your own package only — do NOT touch other packages
5. Commit and push regularly
6. First push → use Push to Upstream, after that just Push
7. Open a Pull Request into `dev` when your module is ready

## Running the Project

Open in NetBeans → Run `Main.java`
